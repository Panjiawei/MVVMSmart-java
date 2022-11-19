package com.wzq.sample.bean;

import java.io.Serializable;
import java.util.List;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@lombok.NoArgsConstructor
@lombok.Data
class pan implements Serializable {


    @com.fasterxml.jackson.annotation.JsonProperty("status")
    private String status;
    @com.fasterxml.jackson.annotation.JsonProperty("message")
    private String message;
    @com.fasterxml.jackson.annotation.JsonProperty("data")
    private DataDTO data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataDTO implements Serializable {
        @com.fasterxml.jackson.annotation.JsonProperty("title")
        private TitleDTO title;
        @com.fasterxml.jackson.annotation.JsonProperty("content")
        private List<ContentDTO> content;

        public TitleDTO getTitle() {
            return title;
        }

        public void setTitle(TitleDTO title) {
            this.title = title;
        }

        public List<ContentDTO> getContent() {
            return content;
        }

        public void setContent(List<ContentDTO> content) {
            this.content = content;
        }

        @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
        public static class TitleDTO implements Serializable {
            @com.fasterxml.jackson.annotation.JsonProperty("id")
            private String id;
            @com.fasterxml.jackson.annotation.JsonProperty("name")
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
        public static class ContentDTO implements Serializable {
            @com.fasterxml.jackson.annotation.JsonProperty("id")
            private String id;
            @com.fasterxml.jackson.annotation.JsonProperty("value")
            private String value;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
