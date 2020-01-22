/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.smoketests

import org.gradle.integtests.fixtures.ToBeFixedForInstantExecution
import org.gradle.profiler.mutations.ApplyNonAbiChangeToJavaSourceFileMutator
import org.gradle.util.GradleVersion
import org.gradle.util.Requires
import org.gradle.util.TestPrecondition
import spock.lang.Unroll

import static org.gradle.testkit.runner.TaskOutcome.SUCCESS


@Requires(TestPrecondition.JDK11_OR_EARLIER)
class AndroidSantaTrackerSmokeTest extends AbstractAndroidSantaTrackerSmokeTest {

    @Unroll
    @ToBeFixedForInstantExecution
    def "check deprecation warnings produced by building Santa Tracker Kotlin (agp=#agpVersion)"() {

        given:
        def checkoutDir = temporaryFolder.createDir("checkout")
        setupCopyOfSantaTracker(checkoutDir, 'Kotlin', agpVersion)

        when:
        def result = buildLocation(checkoutDir, agpVersion)

        then:
        expectDeprecationWarnings(result,
            "The configuration :detachedConfiguration1 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration10 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration11 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration12 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration13 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration14 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration15 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration2 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration3 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration4 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration5 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration6 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration7 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration8 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
            "The configuration :detachedConfiguration9 was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a different project. This behaviour has been deprecated and is scheduled to be removed in Gradle 7.0. See https://docs.gradle.org/${GradleVersion.current().version}/userguide/viewing_debugging_dependencies.html#sub:resolving-unsafe-configuration-resolution-errors for more details.",
        )
        assertInstantExecutionStateStored()

        where:
        agpVersion << TESTED_AGP_VERSIONS
    }

    @Unroll
    def "check deprecation warnings produced by building Santa Tracker Java (agp=#agpVersion)"() {

        given:
        def checkoutDir = temporaryFolder.createDir("checkout")
        setupCopyOfSantaTracker(checkoutDir, 'Java', agpVersion)

        when:
        def result = buildLocation(checkoutDir, agpVersion)

        then:
        if (agpVersion.startsWith('3.6')) {
            expectDeprecationWarnings(result,
                "Internal API constructor DefaultDomainObjectSet(Class<T>) has been deprecated. This is scheduled to be removed in Gradle 7.0. Please use ObjectFactory.domainObjectSet(Class<T>) instead."
            )
        } else {
            expectNoDeprecationWarnings(result)
        }
        assertInstantExecutionStateStored()

        where:
        agpVersion << TESTED_AGP_VERSIONS
    }

    @Unroll
    @ToBeFixedForInstantExecution
    def "incremental Java compilation works for Santa Tracker Kotlin (agp=#agpVersion)"() {

        given:
        def checkoutDir = temporaryFolder.createDir("checkout")
        setupCopyOfSantaTracker(checkoutDir, 'Kotlin', agpVersion)

        and:
        def pathToClass = "com/google/android/apps/santatracker/tracker/ui/BottomSheetBehavior"
        def fileToChange = checkoutDir.file("tracker/src/main/java/${pathToClass}.java")
        def compiledClassFile = checkoutDir.file("tracker/build/intermediates/javac/debug/classes/${pathToClass}.class")
        def nonAbiChangeMutator = new ApplyNonAbiChangeToJavaSourceFileMutator(fileToChange)

        when:
        def result = buildLocation(checkoutDir, agpVersion)
        def md5Before = compiledClassFile.md5Hash

        then:
        result.task(":tracker:compileDebugJavaWithJavac").outcome == SUCCESS
        assertInstantExecutionStateStored()

        when:
        nonAbiChangeMutator.beforeBuild()
        buildLocation(checkoutDir, agpVersion)
        def md5After = compiledClassFile.md5Hash

        then:
        result.task(":tracker:compileDebugJavaWithJavac").outcome == SUCCESS
        assertInstantExecutionStateLoaded()
        md5After != md5Before

        where:
        agpVersion << TESTED_AGP_VERSIONS
    }

    @Unroll
    def "incremental Java compilation works for Santa Tracker Java (agp=#agpVersion)"() {

        given:
        def checkoutDir = temporaryFolder.createDir("checkout")
        setupCopyOfSantaTracker(checkoutDir, 'Java', agpVersion)

        and:
        def pathToClass = "com/google/android/apps/santatracker/map/BottomSheetBehavior"
        def fileToChange = checkoutDir.file("santa-tracker/src/main/java/${pathToClass}.java")
        def compiledClassFile = checkoutDir.file("santa-tracker/build/intermediates/javac/developmentDebug/classes/${pathToClass}.class")
        def nonAbiChangeMutator = new ApplyNonAbiChangeToJavaSourceFileMutator(fileToChange)

        when:
        def result = buildLocation(checkoutDir, agpVersion)
        def md5Before = compiledClassFile.md5Hash

        then:
        result.task(":santa-tracker:compileDevelopmentDebugJavaWithJavac").outcome == SUCCESS
        assertInstantExecutionStateStored()

        when:
        nonAbiChangeMutator.beforeBuild()
        buildLocation(checkoutDir, agpVersion)
        def md5After = compiledClassFile.md5Hash

        then:
        result.task(":santa-tracker:compileDevelopmentDebugJavaWithJavac").outcome == SUCCESS
        assertInstantExecutionStateLoaded()
        md5After != md5Before

        where:
        agpVersion << TESTED_AGP_VERSIONS
    }
}
