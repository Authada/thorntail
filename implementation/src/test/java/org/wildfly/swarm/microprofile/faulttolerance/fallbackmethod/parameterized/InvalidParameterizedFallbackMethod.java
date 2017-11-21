/*
 * Copyright 2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.swarm.microprofile.faulttolerance.fallbackmethod.parameterized;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

@Dependent
public class InvalidParameterizedFallbackMethod {

    @Fallback(fallbackMethod = "fallbackParameterized")
    @Retry(maxRetries = 1)
    public List<String> fooParameterized() {
        throw new IllegalStateException();
    }

    List<Integer> fallbackParameterized() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        return ints;
    }

}
