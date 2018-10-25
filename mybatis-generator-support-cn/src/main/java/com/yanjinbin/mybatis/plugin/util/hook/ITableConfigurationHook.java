/*
 * Copyright (c) 2018.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yanjinbin.mybatis.plugin.util.hook;

import org.mybatis.generator.api.IntrospectedTable;

/**
 * ---------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------
 * @author: hewei
 * @time:2018/5/21 11:24
 * ---------------------------------------------------------------------------
 */
public interface ITableConfigurationHook {
    /**
     * 表配置
     * @param introspectedTable
     */
    void tableConfiguration(IntrospectedTable introspectedTable);
}
