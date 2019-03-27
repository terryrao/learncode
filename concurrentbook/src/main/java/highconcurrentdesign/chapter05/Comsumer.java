package highconcurrentdesign.chapter05;

import com.lmax.disruptor.WorkHandler;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class Comsumer implements WorkHandler<CPData> {
    @Override
    public void onEvent(CPData cpData) throws Exception {
        System.out.println(Thread.currentThread().getId() + ":Event -- "
                + cpData.getData() * cpData.getData() + "--");
    }
}
