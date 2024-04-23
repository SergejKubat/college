package com.fon.college.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.AcademicTitleDto;
import com.fon.college.service.AcademicTitleService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@WebMvcTest(AcademicTitleController.class)
public class AcademicTitleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AcademicTitleService academicTitleService;

    @Test
    @DisplayName("Get all academic titles")
    void getAllAcademicTitlesTest() throws Exception {
        List<AcademicTitleDto> academicTitleDtoList = new ArrayList<>();

        when(academicTitleService.getAll()).thenReturn(academicTitleDtoList);

        mockMvc.perform(get("/api/academic-titles/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Get academic title by id")
    void getAcademicTitleByIdTest() throws Exception {
        long academicTitleId = 1L;

        AcademicTitleDto academicTitleDto = new AcademicTitleDto();

        academicTitleDto.setId(academicTitleId);
        academicTitleDto.setTitle("Academic title 1");

        when(academicTitleService.getById(academicTitleId)).thenReturn(academicTitleDto);

        mockMvc.perform(get("/api/academic-titles/{id}", academicTitleId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Get academic title by id - failure")
    void getAcademicTitleByIdFailureTest() throws Exception {
        long academicTitleId = 1L;

        when(academicTitleService.getById(academicTitleId)).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get("/api/academic-titles/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Create academic title")
    void createAcademicTitleTest() throws Exception {
        AcademicTitleDto academicTitleDto = new AcademicTitleDto();

        academicTitleDto.setId(1L);
        academicTitleDto.setTitle("Academic title 1");

        String academicTitleDtoJSON = objectMapper.writeValueAsString(academicTitleDto);

        when(academicTitleService.create(academicTitleDto)).thenReturn(academicTitleDto);

        mockMvc.perform(post("/api/academic-titles/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(academicTitleDtoJSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Create academic title - failure")
    void createAcademicTitleFailureTest() throws Exception {
        String academicTitleDtoJSON = "";

        mockMvc.perform(post("/api/academic-titles/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(academicTitleDtoJSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_PROBLEM_JSON));
    }

    @Test
    @DisplayName("Update academic title")
    void updateAcademicTitleTest() throws Exception {
        long academicTitleId = 1L;

        AcademicTitleDto academicTitleDto = new AcademicTitleDto();

        academicTitleDto.setId(academicTitleId);
        academicTitleDto.setTitle("Academic title 1");

        String academicTitleDtoJSON = objectMapper.writeValueAsString(academicTitleDto);

        when(academicTitleService.update(academicTitleId, academicTitleDto)).thenReturn(academicTitleDto);

        mockMvc.perform(put("/api/academic-titles/{id}", academicTitleId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(academicTitleDtoJSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Update academic title - failure")
    void updateAcademicTitleFailureTest() throws Exception {
        long academicTitleId = 1L;

        AcademicTitleDto academicTitleDto = new AcademicTitleDto();

        academicTitleDto.setId(academicTitleId);
        academicTitleDto.setTitle("Academic title 1");

        String academicTitleDtoJSON = objectMapper.writeValueAsString(academicTitleDto);

        when(academicTitleService.update(academicTitleId, academicTitleDto)).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(put("/api/academic-titles/{id}", academicTitleId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(academicTitleDtoJSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Delete academic title")
    void deleteAcademicTitleTest() throws Exception {
        long academicTitleId = 1L;

        doNothing().when(academicTitleService).delete(academicTitleId);

        mockMvc.perform(delete("/api/academic-titles/{id}", academicTitleId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete academic title - failure")
    void deleteAcademicTitleFailureTest() throws Exception {
        long academicTitleId = 1L;

        doThrow(ResourceNotFoundException.class).when(academicTitleService).delete(academicTitleId);

        mockMvc.perform(delete("/api/academic-titles/{id}", academicTitleId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
