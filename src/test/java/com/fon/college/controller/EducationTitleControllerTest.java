package com.fon.college.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.EducationTitleDto;
import com.fon.college.service.EducationTitleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EducationTitleController.class)
public class EducationTitleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EducationTitleService educationTitleService;

    @Test
    @DisplayName("Get all education titles")
    void getAllEducationTitlesTest() throws Exception {
        List<EducationTitleDto> educationTitleDtoList = new ArrayList<>();

        when(educationTitleService.getAll()).thenReturn(educationTitleDtoList);

        mockMvc.perform(get("/api/education-titles/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Get education title by id")
    void getEducationTitleByIdTest() throws Exception {
        long educationTitleId = 1L;

        EducationTitleDto educationTitleDto = new EducationTitleDto();

        educationTitleDto.setId(educationTitleId);
        educationTitleDto.setTitle("Education title 1");

        when(educationTitleService.getById(educationTitleId)).thenReturn(educationTitleDto);

        mockMvc.perform(get("/api/education-titles/{id}", educationTitleId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Get education title by id - failure")
    void getEducationTitleByIdFailureTest() throws Exception {
        long educationTitleId = 1L;

        when(educationTitleService.getById(educationTitleId)).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get("/api/education-titles/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Create eduction title")
    void createEductionTitleTest() throws Exception {
        EducationTitleDto educationTitleDto = new EducationTitleDto();

        educationTitleDto.setId(1L);
        educationTitleDto.setTitle("Education title 1");

        String educationTitleDtoJSON = objectMapper.writeValueAsString(educationTitleDto);

        when(educationTitleService.create(educationTitleDto)).thenReturn(educationTitleDto);

        mockMvc.perform(post("/api/education-titles/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(educationTitleDtoJSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Create education title - failure")
    void createEducationTitleFailureTest() throws Exception {
        String educationTitleDtoJSON = "";

        mockMvc.perform(post("/api/education-titles/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(educationTitleDtoJSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_PROBLEM_JSON));
    }

    @Test
    @DisplayName("Update education title")
    void updateEducationTitleTest() throws Exception {
        long educationTitleId = 1L;

        EducationTitleDto educationTitleDto = new EducationTitleDto();

        educationTitleDto.setId(educationTitleId);
        educationTitleDto.setTitle("Education title 1");

        String educationTitleDtoJSON = objectMapper.writeValueAsString(educationTitleDto);

        when(educationTitleService.update(educationTitleId, educationTitleDto)).thenReturn(educationTitleDto);

        mockMvc.perform(put("/api/education-titles/{id}", educationTitleId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(educationTitleDtoJSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Update education title - failure")
    void updateEducationTitleFailureTest() throws Exception {
        long educationTitleId = 1L;

        EducationTitleDto educationTitleDto = new EducationTitleDto();

        educationTitleDto.setId(educationTitleId);
        educationTitleDto.setTitle("Education title 1");

        String educationTitleDtoJSON = objectMapper.writeValueAsString(educationTitleDto);

        when(educationTitleService.update(educationTitleId, educationTitleDto)).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(put("/api/education-titles/{id}", educationTitleId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(educationTitleDtoJSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Delete education title")
    void deleteEducationTitleTest() throws Exception {
        long educationTitleId = 1L;

        doNothing().when(educationTitleService).delete(educationTitleId);

        mockMvc.perform(delete("/api/education-titles/{id}", educationTitleId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete education title - failure")
    void deleteEducationTitleFailureTest() throws Exception {
        long educationTitleId = 1L;

        doThrow(ResourceNotFoundException.class).when(educationTitleService).delete(educationTitleId);

        mockMvc.perform(delete("/api/education-titles/{id}", educationTitleId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
