/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package com.gaadi.sfa.annotations;

import com.gaadi.sfa.annotations.rules.Rules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to annotate Mobile Number entered by the user.
 *
 * @author Ankit Garg <ankit.garg@jeevansathi.com>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileNumber {

    public int order();

    public boolean trim() default true;

    public int minLength() default Integer.MIN_VALUE;

    public int maxLength() default Integer.MAX_VALUE;

    public String message() default Rules.EMPTY_STRING;

    public int messageResId() default 0;
}
