package com.j62u63310.server.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private boolean success;
    private Result result;
    private Records records;

    @Override
    public String toString() {
        return "Weather{" +
                "success=" + success +
                ", result=" + result +
                ", records=" + records +
                '}';
    }

    @Getter
    @Setter
    public static class Result {
        private String resource_id;
        private Field[] fields;

        @Getter
        @Setter
        public static class Field {
            private String id;
            private String type;
        }
    }

    @Getter
    @Setter
    public static class Records {
        private String datasetDescription;
        private Location[] location;

        @Getter
        @Setter
        public static class Location {
            private String locationName;
            private WeatherElement[] weatherElement;

            @Getter
            @Setter
            public static class WeatherElement {
                private String elementName;
                private Time[] time;

                @Getter
                @Setter
                public static class Time {
                    private String startTime;
                    private String endTime;
                    private Parameter parameter;

                    @Getter
                    @Setter
                    public static class Parameter {
                        private String parameterName;
                        private String parameterValue;
                        private String parameterUnit;
                    }
                }
            }
        }
    }
}
