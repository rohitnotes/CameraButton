/*
 * Copyright (C) 2017 Artem Glugovsky
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

package com.dewarder.camerabutton.util

import android.support.test.espresso.matcher.BoundedMatcher
import android.view.View

import com.dewarder.camerabutton.CameraButton

import org.hamcrest.Description
import org.hamcrest.Matcher

fun state(state: CameraButton.State): Matcher<in View> = StateMatcher(state)

private class StateMatcher(
        private val state: CameraButton.State
) : BoundedMatcher<View, CameraButton>(CameraButton::class.java) {

    override fun matchesSafely(item: CameraButton) = item.state == state

    override fun describeTo(description: Description) {
        description.appendText("with button state: $state")
    }
}
