package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger; // Http request 요청이 없는데 의존성 주입 받으면 오류!

    @RequestMapping("log-demo")
    @ResponseBody // 문자열 그대로 보냄
    public String logDemo(HttpServletRequest request) { // 자바에서 제공하는 표준 서블릿 규약에 의한 Http request 정보 받을 수 있음
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}
