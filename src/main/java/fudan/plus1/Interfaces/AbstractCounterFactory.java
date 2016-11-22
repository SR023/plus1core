package fudan.plus1.Interfaces;

/**
 * Created by billlai on 08/Oct/2016.
 */

public interface AbstractCounterFactory {
    AbstractCounter createCounter(String administrator,
                                  String counterName,
                                  double value,
                                  double step,
                                  String unit);

    AbstractCounter findCounter(String counterId);

    int deleteCounter(String administrator, String counterId);
}