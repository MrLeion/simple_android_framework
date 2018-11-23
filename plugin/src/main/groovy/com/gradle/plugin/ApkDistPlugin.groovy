package com.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class ApkDistPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('apkdistconf', ApkDistExtension);
        project.task('apkdist') << {
            println 'hello, tzl!'

            def closure = project['apkdistconf'].nameMap;
            closure('xs!');

            println project['apkdistconf'].destDir
        }
    }
}





