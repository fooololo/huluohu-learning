package com.huluohu.learning.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by huluohu on 2016/5/15.
 */
@Service
@Scope(value = "singleton")
public class DemoSingletonService {
}
