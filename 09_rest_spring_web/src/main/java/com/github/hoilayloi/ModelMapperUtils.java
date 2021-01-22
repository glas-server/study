package com.github.hoilayloi;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/*
 *
 * @author halab
 */
@Slf4j
public class ModelMapperUtils {

    private static final ModelMapper MODEL_MAPPER = getMapper();

    private static ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }

    private ModelMapperUtils() {
    }

    public static <T> T toObject(Object obj, Class<T> type) {
        if (obj == null) {
            return null;
        }
        T t = null;
        try {
            t = MODEL_MAPPER.map(obj, type);
        } catch (Exception ex) {
            log.error("Map objects error", ex);
        }
        return t;
    }
}
