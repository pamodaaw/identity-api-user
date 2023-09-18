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

package org.wso2.carbon.identity.rest.api.user.registration.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * Contains the data related to a link.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Contains the data related to a link.")
public class Link  {
  
    private String name;
    private String href;

@XmlType(name="MethodEnum")
@XmlEnum(String.class)
public enum MethodEnum {

    @XmlEnumValue("GET") GET(String.valueOf("GET")), @XmlEnumValue("POST") POST(String.valueOf("POST"));


    private String value;

    MethodEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static MethodEnum fromValue(String value) {
        for (MethodEnum b : MethodEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private MethodEnum method;

    /**
    * The identifier of the link.
    **/
    public Link name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "registration", required = true, value = "The identifier of the link.")
    @JsonProperty("name")
    @Valid
    @NotNull(message = "Property name cannot be null.")

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
    * The relative url of the link.
    **/
    public Link href(String href) {

        this.href = href;
        return this;
    }
    
    @ApiModelProperty(example = "/api/registration/v1", required = true, value = "The relative url of the link.")
    @JsonProperty("href")
    @Valid
    @NotNull(message = "Property href cannot be null.")

    public String getHref() {
        return href;
    }
    public void setHref(String href) {
        this.href = href;
    }

    /**
    * The supported http methods of the link.
    **/
    public Link method(MethodEnum method) {

        this.method = method;
        return this;
    }
    
    @ApiModelProperty(example = "POST", required = true, value = "The supported http methods of the link.")
    @JsonProperty("method")
    @Valid
    @NotNull(message = "Property method cannot be null.")

    public MethodEnum getMethod() {
        return method;
    }
    public void setMethod(MethodEnum method) {
        this.method = method;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Link link = (Link) o;
        return Objects.equals(this.name, link.name) &&
            Objects.equals(this.href, link.href) &&
            Objects.equals(this.method, link.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, href, method);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class Link {\n");
        
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
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

