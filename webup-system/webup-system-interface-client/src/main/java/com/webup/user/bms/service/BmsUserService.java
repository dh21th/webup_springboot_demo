package com.webup.user.bms.service;

import com.webup.user.bms.fallback.BaseServiceFallback;
import com.webup.user.bms.pojo.BmsUser;
import com.webup.user.bms.pojo.BmsUserQueryParams;
import com.webup.user.bms.pojo.BmsUserUpdateParams;
import com.webup.user.common.CommonConst;
import com.webup.soa.base.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author denghua
 * @version 1.2
 * @project yzys
 * @class_name BmsUserService
 * @date 2017-07-31 17:54
 */
//@FeignClient(
//        name = "yz-demo"
//)
////@YzFeignClient
//public interface BmsUserService extends BaseFeignClient<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> {
//    @RequestMapping({"/com_demo_user_bms_client/bmsUserService/getUserByLoginName"})
//    BmsUser getUserByLoginName(@RequestParam("name") String name);
//}

@FeignClient(
        value = "yz-demo",
        path = "com_demo_user_bms_service/bmsUserService"
//        ,fallback = BmsUserService.Fallback.class
)
//@YzFeignClient
public interface BmsUserService extends BaseFeignClient<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> { //
    @RequestMapping({"/getUserByLoginName"})
    BmsUser getUserByLoginName(@RequestParam("name") String name) throws Exception;

//    @Component
//    class Fallback extends BaseServiceFallback<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> implements BmsUserService{ //
//        private static final Logger log = LoggerFactory.getLogger(Fallback.class);
//        @Override
//        public BmsUser getUserByLoginName(String name) throws Exception{ //
//            log.error("BmsUserService getUserByLoginName Fallback");
//            throw new HystrixException();
//        }
//    }
}


////@FeignClient(name = CommonConst.FeignClientServerName,fallback = BmsUserService.Fallback.class)
//@YzFeignClient
//public interface BmsUserService extends BaseFeignClient<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> {
//
//    /**
//     * 查询
//     * @return String
//     */
////    @YzFeignClient.Disable
////    @RequestMapping({"/com_demo_user_bms_service/bmsUserService/getUserByLoginName"})
//    BmsUser getUserByLoginName(String name);
//
//
////    @Data
////    @Slf4j
////    class Fallback extends BaseServiceFallback<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> implements BmsUserService {
////        private String msgCaptionPreFix;
////        Fallback(String msgCaptionPreFix){
////            this.msgCaptionPreFix = msgCaptionPreFix;
////        }
////        @Override
////        public BmsUser getUserByLoginName(String name) {
////            return null;
////        }
////    }
//
//}
