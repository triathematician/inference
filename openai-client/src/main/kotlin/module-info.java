module triathematician.dljtesting {
    requires kotlin.stdlib.jdk8;
    requires kotlin.stdlib.jdk7;
    requires kotlin.stdlib;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.kotlin;
    requires okhttp3;

    opens org.tri.openai to com.fasterxml.jackson.databind;

    exports org.tri.openai;
}