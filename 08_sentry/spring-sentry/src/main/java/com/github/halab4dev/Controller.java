package com.github.halab4dev;

import io.sentry.Sentry;
import io.sentry.event.UserBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author halab
 */
@Slf4j
@RestController
@RequestMapping("/sentry")
public class Controller {

    @GetMapping("/success")
    public String successRequest(
    ) {
        log.debug("successRequest");
        return "OK";
    }

    @GetMapping("/fail")
    public String failRequest(
            @RequestParam("message") String message
    ) {
        log.debug("failRequest");
        Sentry.getContext().setUser(new UserBuilder().setId("user id 1").build());
        Sentry.getContext().addTag("api", "fail");
        Sentry.getContext().addExtra("request data", message);
        throw new NullPointerException();
    }

    @GetMapping("/try-catch")
    public String tryCatchRequest(
            @RequestParam("message") String message
    ) {
        log.debug("tryCatchRequest");
        Sentry.getContext().setUser(new UserBuilder().setId("user id 1").build());
        Sentry.getContext().addTag("api", "fail");
        Sentry.getContext().addExtra("request data", message);
        try {
            throw new NullPointerException();
        } catch(Exception ex) {
            log.error("", ex);
            return "Not OK";
        }
    }

    @GetMapping("/try-catch-cover")
    public String tryCatchCoverRequest(
            @RequestParam("message") String message
    ) {
        Sentry.getContext().setUser(new UserBuilder().setId("user id 1").build());
        Sentry.getContext().addTag("api", "fail");
        Sentry.getContext().addExtra("request data", message);
        try {
            throw new NullPointerException();
        } catch(Exception ex) {
            log.error("", ex);
            Sentry.capture(ex);
            return "Not OK";
        }
    }
}
