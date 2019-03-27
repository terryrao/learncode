package highconcurrentdesign.chapter05;

import com.lmax.disruptor.EventFactory;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class CPDatatFactory implements EventFactory<CPData> {
    @Override
    public CPData newInstance() {
        return new CPData();
    }
}
