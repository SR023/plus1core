package Interfaces;

/**
 * Created by billlai on 08/Oct/2016.
 */

public interface AbstractMultiUserCounterFactory {
     Counter createMultiUserCounter(String counterId, String counterPassword, String counterName,
                                      double value, double step, String unit);
     boolean isCounterIdAvailable(String counterId);
     boolean isCounterIdLegal(String counterId);
     boolean isAbleToAddMultiUserCounter(String counterId, String counterPassword);
     Counter addMultiUserCounter(String counterId, String counterPassword);
     int deleteCounter(String counterId);
}
