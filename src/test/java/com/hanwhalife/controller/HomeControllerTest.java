package com.hanwhalife.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
@ExtendWith(SpringExtension.class)
class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void info() throws Exception {
        mockMvc
                .perform(get("/service-info"))
                .andExpect(status().isOk())
                .andDo(document("get-service-info"
                    , resource("Get service info")));
    }

    @Test
    void test1() throws Exception {
        mockMvc
                .perform(get("/test"))
                .andExpect(status().isOk())
                .andDo(document("test"
                        , resource("Get test")));
    }
}