package com.skye.demo.topics


@Retention
@Target(AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
annotation class ExcludeFromJacocoGeneratedReport 
