package com.thefuntasty.androidprojecttemplate

import ProjectSettings
import org.gradle.api.DefaultTask
import org.gradle.api.plugins.ExtraPropertiesExtension
import org.gradle.kotlin.dsl.configure

open class BitriseLint : DefaultTask() {

    init {
        group = ProjectSettings.TASK_GROUP

        configure<ExtraPropertiesExtension> {
            dependsOn("detekt")
            project.subprojects.forEach {
                dependsOn("${it.name}:ktlintCheck")
            }
        }
    }
}
