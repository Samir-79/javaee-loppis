package timerejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Date;



@Singleton
@LocalBean
@Startup
public class IntervalTimerEJB {

    @Resource
    private TimerService timerService;

    @PostConstruct
    private void init() {
        timerService.createTimer(1000,3000,"IntervalTimer");
    }

    @Timeout
    public  void execute(Timer timer) {
        System.out.println("Timer Service:" + timer.getInfo());
        System.out.println("Current time:" + new Date());
        System.out.println("Next Timeout:" + timer.getNextTimeout());
        System.out.println("Time remaining: " + timer.getTimeRemaining());
        System.out.println("---------------------------------------------------");
    }
}
