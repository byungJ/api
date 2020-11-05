//package com.pic2cheese.user;
//
//import com.pic2cheese.subscription.Subscription;
//import com.pic2cheese.subscription.SubscriptionRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Transactional
//@Service
//@RequiredArgsConstructor
//public class MyInfoService {
//
//    private final UserRepository userRepository;
//    private final SubscriptionRepository subscriptionRepository;
//
//    public Boolean register(Long userNo){
//
//        User user = userRepository.findOne(userNo);
//        Subscription subscription = new Subscription();
//        Subscription subscription2 = subscriptionRepository.findOne(subscription.getId());
//
//        return true;
//    }
//
//}
