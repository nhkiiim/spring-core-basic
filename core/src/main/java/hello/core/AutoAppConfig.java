package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 학습하며 만들어둔 Configuration 필터링
) // @Component 애너테이션을 찾아가 자동으로 컨테이너에 등록해줌
@Configuration
public class AutoAppConfig {

}
