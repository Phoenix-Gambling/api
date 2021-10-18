package phoenix.api.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class MemoryCache {

    private static final Map<String, Object> cache = new HashMap<>();

    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static <T> void set(String key, T value, long time, TimeUnit timeUnit) {
        cache.put(key, value);
        scheduler.schedule(() -> cache.remove(key), time, timeUnit);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key, Supplier<T> supplier, long time, TimeUnit timeUnit) {
        if(cache.containsKey(key)) return (T) cache.get(key);

        try {
            T value = supplier.get();
            cache.put(key, value);

            scheduler.schedule(() -> cache.remove(key), time, timeUnit);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T get(String key, Supplier<T> supplier, int minutes) {
        return get(key, supplier, minutes, TimeUnit.MINUTES);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return !cache.containsKey(key) ? null : (T) cache.get(key);
    }

    public static void clear() {
        cache.clear();
    }

    public static void clear(String key) {
        cache.remove(key);
    }

}
