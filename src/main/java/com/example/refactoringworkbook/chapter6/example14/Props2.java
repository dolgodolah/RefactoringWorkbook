package com.example.refactoringworkbook.chapter6.example14;

import java.util.Properties;

public class Props2 {

    private static String INTERVAL_PROP = "interval";
    private static String DURATION_PROP = "duration";
    private static String DEPARTURE_PROP = "departure";

    private int checkInterval;
    private int monitorTime;
    private int departureOffset;

    public void getTimes(Properties props) throws Exception {
        validatePropsMissing(props);
        validatePropsPositive(props);
        checkInterval = parsePropertyValue(props, INTERVAL_PROP);

        validateIntervalMultiple(props);
        monitorTime = parsePropertyValue(props, DURATION_PROP);
        departureOffset = parsePropertyValue(props, DEPARTURE_PROP);
    }

    private void validatePropsMissing(Properties props) throws MissingPropertiesException {
        if (props.getProperty(INTERVAL_PROP) == null || props.getProperty(DURATION_PROP) == null) {
            throw new MissingPropertiesException("monitor " + null);
        }

        if (props.getProperty(DEPARTURE_PROP) == null) {
            throw new MissingPropertiesException("departure offset");
        }
    }

    private void validatePropsPositive(Properties props) throws MissingPropertiesException {
        String valueString;
        int value;

        valueString = props.getProperty(INTERVAL_PROP);
        value = Integer.parseInt(valueString);
        if (value <= 0) {
            throw new MissingPropertiesException("monitor interval > 0");
        }

        valueString = props.getProperty(DURATION_PROP);
        value = Integer.parseInt(valueString);
        if (value <= 0) {
            throw new MissingPropertiesException("duration > 0");
        }

        valueString = props.getProperty(DEPARTURE_PROP);
        value = Integer.parseInt(valueString);
        if (value <= 0) {
            throw new MissingPropertiesException("departure > 0");
        }
    }

    private void validateIntervalMultiple(Properties props) throws MissingPropertiesException {
        assert checkInterval > 0;

        String valueString;
        int value;

        valueString = props.getProperty(DURATION_PROP);
        value = Integer.parseInt(valueString);

        if ((value % checkInterval) != 0) {
            throw new MissingPropertiesException("duration % checkInterval");
        }

        valueString = props.getProperty(DEPARTURE_PROP);
        value = Integer.parseInt(valueString);
        if ((value % checkInterval) != 0) {
            throw new MissingPropertiesException("departure % checkInterval");
        }
    }

    private int parsePropertyValue(Properties props, String propName) {
        String valueString = props.getProperty(propName);
        return Integer.parseInt(valueString);
    }
}
