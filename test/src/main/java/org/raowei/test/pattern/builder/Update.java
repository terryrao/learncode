/*
 * Copyright (c) 2015. [${USER}]
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

package org.raowei.test.pattern.builder;

/**
 * @author terryrao
 * @version 1.0 6/10/2015 9:07 PM
 */
public class Update {
    private final String author;
    private final String updateText;

    public Update(String author, String updateText) {
        this.author = author;
        this.updateText = updateText;
    }

    public static class Builder implements ObjectBuilder<Update> {
        private String author;
        private String updateText;
        public Builder setAuthor (String author) {
            this.author = author;
            return this;
        }

        public Builder setUpdateText (String updateText) {
            this.updateText = updateText;
            return this;
        }



        @Override
        public Update build() {
            return new Update(author,updateText);
        }
    }

    @Override
    public String toString() {
        return "Update{" +
                "author='" + author + '\'' +
                ", updateText='" + updateText + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Builder  builder= new Update.Builder();
        Update update = builder.setAuthor("terry").setUpdateText("builder test").build();
        System.out.println(update.toString());
    }
}
