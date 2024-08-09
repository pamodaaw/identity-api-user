/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.rest.api.user.registration.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.Element;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class Section  {
  
    private String id;
    private Integer order;

@XmlType(name="ModeEnum")
@XmlEnum(String.class)
public enum ModeEnum {

    @XmlEnumValue("allOf") ALLOF(String.valueOf("allOf")), @XmlEnumValue("oneOf") ONEOF(String.valueOf("oneOf"));


    private String value;

    ModeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ModeEnum fromValue(String value) {
        for (ModeEnum b : ModeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private ModeEnum mode;
    private List<Element> elements = null;


    /**
    * A unique id for the element in the next step array.
    **/
    public Section id(String id) {

        this.id = id;
        return this;
    }
    
    @ApiModelProperty(value = "A unique id for the element in the next step array.")
    @JsonProperty("id")
    @Valid
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /**
    * Depictd the order in which the elements should be processed in the array.
    **/
    public Section order(Integer order) {

        this.order = order;
        return this;
    }
    
    @ApiModelProperty(value = "Depictd the order in which the elements should be processed in the array.")
    @JsonProperty("order")
    @Valid
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
    * execution mode
    **/
    public Section mode(ModeEnum mode) {

        this.mode = mode;
        return this;
    }
    
    @ApiModelProperty(example = "allOf", value = "execution mode")
    @JsonProperty("mode")
    @Valid
    public ModeEnum getMode() {
        return mode;
    }
    public void setMode(ModeEnum mode) {
        this.mode = mode;
    }

    /**
    **/
    public Section elements(List<Element> elements) {

        this.elements = elements;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("elements")
    @Valid
    public List<Element> getElements() {
        return elements;
    }
    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public Section addElementsItem(Element elementsItem) {
        if (this.elements == null) {
            this.elements = new ArrayList<>();
        }
        this.elements.add(elementsItem);
        return this;
    }

    

    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Section section = (Section) o;
        return Objects.equals(this.id, section.id) &&
            Objects.equals(this.order, section.order) &&
            Objects.equals(this.mode, section.mode) &&
            Objects.equals(this.elements, section.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, mode, elements);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class Section {\n");
        
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    elements: ").append(toIndentedString(elements)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
    private String toIndentedString(java.lang.Object o) {

        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n");
    }
}

