module triathematician.dljtesting {
    requires kotlin.stdlib.jdk8;
    requires kotlin.stdlib.jdk7;
    requires kotlin.stdlib;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.kotlin;
    requires okhttp3;
    requires retrofit2;
    requires retrofit2.converter.jackson;
    requires okhttp3.logging;

    opens org.tri.openai.api.dto to com.fasterxml.jackson.databind, kotlin.reflect;

    exports org.tri.openai;
    exports org.tri.openai.api;
}