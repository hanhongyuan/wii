package com.platform.actor.weixin;

import akka.actor.UntypedActor;
import com.platform.actor.config.AkkaBeanFactory;
import com.platform.actor.dto.AddTagInUserMsg;
import com.platform.actor.dto.InitMenuMsg;
import com.platform.common.consts.WxConsts;
import com.platform.common.manage.WxCacheManage;
import com.platform.common.weixin.api.MenuApi;
import com.platform.common.weixin.api.UserApi;
import com.platform.common.weixin.dto.WxUserTagInfoDto;
import com.platform.common.weixin.model.Menu;
import com.platform.web.entity.WechatGroupInfo;
import com.platform.web.mapper.WechatGroupInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.platform.common.configs.CommonConfig.WxConfig.domain;
import static com.platform.common.configs.CommonConfig.WxConfig.token;

/**
 * Created by tanghong on 2017/3/19.
 */
public class MenuActor extends UntypedActor {
    private Logger logger = LoggerFactory.getLogger(MenuActor.class);

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof AddTagInUserMsg){
            AddTagInUserMsg msg = (AddTagInUserMsg)message;
            addUserTag(msg.getStoreId());
        }
        else if (message instanceof InitMenuMsg) {
            InitMenuMsg msg = (InitMenuMsg)message;
            initMenu(msg);
        }
    }

    private void  addUserTag(int storeId){
        WxCacheManage manage = AkkaBeanFactory.getBean("wxCacheManage");
        WechatGroupInfoMapper groupInfo = AkkaBeanFactory.getBean("wechatGroupInfoMapper");
        List<WechatGroupInfo> list = groupInfo.selectGroupInfo(storeId);
        Optional<String> tokenOpt = manage.getAuthAccessToken(storeId);

        Consumer<String> createGroup = token -> {
            Arrays.asList(WxConsts.UserTagCons.values()).stream().forEach(f -> {
                try {
                    Optional<WxUserTagInfoDto> opt = UserApi.createUserTag(token, f.getName());
                    if (opt.isPresent()) {
                        WechatGroupInfo info = new WechatGroupInfo(
                            storeId,
                            f.getId(),
                            opt.get().getGroup().getId(),
                            opt.get().getGroup().getName()
                        );
                        groupInfo.insert(info);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            });
        };

        if(list == null || list.isEmpty()) {
            if (tokenOpt.isPresent()) {
                String token = tokenOpt.get();
                createGroup.accept(token);
            }
        }
        else {
            if (tokenOpt.isPresent()) {
                String token = tokenOpt.get();
                list.stream().forEach(f -> {
                    try {
                        Optional<String> res = UserApi.delUserGroup(token, f.getGroupId());
                        logger.info("删除分组: " + res);
                        groupInfo.deleteByPrimaryKey(f.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                createGroup.accept(token);

            }
        }
    }

    private void initMenu(InitMenuMsg msg){
        //addUserTag(msg.storeId)
        createMenu(msg.getStoreId(), msg.getAccessToken());
    }

    /*private[this] def initCustomeBuiltMenu(msg: CustomBuiltMsg): Unit = {
        //addUserTag(msg.storeId)
        createCustomBuiltMenu(msg.storeId, msg.accessToken, msg.domain)
    }*/

    private void createMenu(int storeId, String accessToken) {
        try {
            MenuApi.deleteMenu(accessToken);
            MenuApi.createMenu(Menu.getDefaultMenu(storeId), accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createCustomBuiltMenu(int storeId, String accessToken){
        //val groupInfo = AkkaBeanFactory.getBean[WechatGroupInfoMapper]("wechatGroupInfoMapper")
        //val defaultMenu = Menu.getCustomBuiltMenu(storeId, domain)
        //MenuApi.deleteMenu(accessToken)
        //MenuApi.createMenu(Menu(defaultMenu).toJson, accessToken)
    /*groupInfo.selectGroupInfo(storeId).map{ f =>
      f.groupType match {
        case gt if gt == 1 => (Menu.getMemberMenu(storeId, domain), f.groupId, 1)
        case gt if gt == 2 => (Menu.getEmployeeMenu(storeId, domain), f.groupId, 2)
        case gt if gt == 3 => (Menu.getBossMenu(storeId, domain), f.groupId, 3)
        case gt if gt == 4 => (defaultMenu, f.groupId, 4)
      }
    }.sortBy(_._3).foreach{ case (list, groupId, _) =>
      logger.info(s"分组编号:${groupId}")
      // 返回menuid
      MenuApi.createIndividuationMenu(Menu(list).toJson, accessToken, groupId).foreach{ f =>
        logger.info(s"菜单返回结果: ${f}")
      }
    }*/
    }
}
