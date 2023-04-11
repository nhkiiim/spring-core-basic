package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    // requestURL을 MyLogger에 저장하는 부분은 원래는 인터셉터나 필터를 활용하는 것이 좋으나, 일단은 컨트롤러 사용

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerObjectProvider; // Http request 요청이 없는데 의존성 주입 받으면 오류!

    @RequestMapping("log-demo")
    @ResponseBody // 문자열 그대로 보냄
    public String logDemo(HttpServletRequest request) { // 자바에서 제공하는 표준 서블릿 규약에 의한 Http request 정보 받을 수 있음
        // 원하는 시점에 MyLogger 의존성 주입 - Http request 있을 때
        // MyLogger myLogger = myLoggerObjectProvider.getObject();
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}
