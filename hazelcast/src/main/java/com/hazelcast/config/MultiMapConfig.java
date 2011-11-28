/* 
 * Copyright (c) 2008-2010, Hazel Ltd. All Rights Reserved.
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
 *
 */

package com.hazelcast.config;

import com.hazelcast.nio.DataSerializable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class MultiMapConfig implements DataSerializable {

    public MultiMapConfig(MultiMapConfig defConfig) {
        this.name = defConfig.getName();
        this.valueCollectionType = defConfig.getValueCollectionType().toString();
    }

    public MultiMapConfig() {
    }

    public enum ValueCollectionType {
        SET,
        LIST
    }

    String name;
    String valueCollectionType = ValueCollectionType.SET.toString();

    public void writeData(DataOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(valueCollectionType);
    }

    public void readData(DataInput in) throws IOException {
        name = in.readUTF();
        valueCollectionType = in.readUTF();
    }

    public String getName() {
        return name;
    }

    public MultiMapConfig setName(String name) {
        this.name = name;
        return this;
    }

    public ValueCollectionType getValueCollectionType() {
        return ValueCollectionType.valueOf(valueCollectionType.toUpperCase());
    }

    public MultiMapConfig setValueCollectionType(String valueCollectionType) {
        this.valueCollectionType = valueCollectionType;
        return this;
    }
}
