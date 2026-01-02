package com.example.refactoringworkbook.chapter6.example14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class Props2Test {
    @Test
    @DisplayName("interval 속성은 반드시 필요하다.")
    public void testPropsIntervalMissing() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        assertThrowsExactly(MissingPropertiesException.class, () -> props.getTimes(properties));
    }

    @Test
    @DisplayName("interval 속성은 양수여야 한다.")
    public void testPropsIntervalPositive() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        properties.setProperty("interval", "-1");
        assertThrowsExactly(MissingPropertiesException.class, () -> props.getTimes(properties));
    }

    @Test
    @DisplayName("duration 속성은 반드시 필요하다.")
    public void testPropsDurationMissing() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        properties.setProperty("interval", "5");
        assertThrowsExactly(MissingPropertiesException.class, () -> props.getTimes(properties));
    }

    @Test
    @DisplayName("duration 속성은 양수여야 한다.")
    public void testPropsDurationPositive() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        properties.setProperty("interval", "5");
        properties.setProperty("duration", "-10");
        assertThrowsExactly(MissingPropertiesException.class, () -> props.getTimes(properties));
    }

    @Test
    @DisplayName("duration 속성은 interval의 배수여야 한다.")
    public void testPropsDurationMultipleOfInterval() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        properties.setProperty("interval", "6");
        properties.setProperty("duration", "10");
        assertThrowsExactly(MissingPropertiesException.class, () -> props.getTimes(properties));
    }

    @Test
    @DisplayName("departure 속성은 반드시 필요하다.")
    public void testPropsDepartureMissing() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        properties.setProperty("interval", "5");
        properties.setProperty("duration", "10");
        assertThrowsExactly(MissingPropertiesException.class, () -> props.getTimes(properties));
    }

    @Test
    @DisplayName("departure 속성은 양수여야 한다.")
    public void testPropsDeparturePositive() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        properties.setProperty("interval", "5");
        properties.setProperty("duration", "10");
        properties.setProperty("departure", "-3");
        assertThrowsExactly(MissingPropertiesException.class, () -> props.getTimes(properties));
    }

    @Test
    @DisplayName("departure 속성은 interval의 배수여야 한다.")
    public void testPropsDepartureMultipleOfInterval() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        properties.setProperty("interval", "4");
        properties.setProperty("duration", "12");
        properties.setProperty("departure", "10");
        assertThrowsExactly(MissingPropertiesException.class, () -> props.getTimes(properties));
    }

    @Test
    @DisplayName("모든 속성이 올바르게 설정된 경우 예외가 발생하지 않는다.")
    public void testPropsAllValid() {
        Props2 props = new Props2();
        Properties properties = new Properties();
        properties.setProperty("interval", "5");
        properties.setProperty("duration", "20");
        properties.setProperty("departure", "10");
        assertDoesNotThrow(() -> props.getTimes(properties));
    }
}