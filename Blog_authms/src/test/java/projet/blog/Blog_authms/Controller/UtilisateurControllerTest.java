package projet.blog.Blog_authms.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import projet.blog.Blog_authms.controllers.UtilisateurController;
import projet.blog.Blog_authms.entities.Utilisateur;
import projet.blog.Blog_authms.models.AuthenticationRequest;
import projet.blog.Blog_authms.models.AuthenticationResponse;
import projet.blog.Blog_authms.models.RegisterRequest;
import projet.blog.Blog_authms.services.AuthenticationService;
import projet.blog.Blog_authms.services.UtilisateurService;

import static org.mockito.Mockito.when;
import static projet.blog.Blog_authms.entities.Role.USER;


import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;


    @SpringBootTest
    @AutoConfigureMockMvc
    public class UtilisateurControllerTest {

        @Mock
        private UtilisateurService utilisateurService;

        @Mock
        private AuthenticationService authenticationService;

        @InjectMocks
        private UtilisateurController utilisateurController;

        @Autowired
        private MockMvc mockMvc;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.openMocks(this);
        }
        RegisterRequest registerRequest = RegisterRequest.builder()
                .username("ouissal1")
                .password("testPassword")
                .nom("hadid")
                .prenom("ouissal")
                .email("hadid@example.com")
                .role(USER) // Assuming Role is an enum in your application
                .build();

        // Create an AuthenticationResponse object

        @Test
        public void testRegisterEndpoint() throws Exception {
            // Create a RegisterRequest object
            RegisterRequest registerRequest = RegisterRequest.builder()
                    .username("ouissal1")
                    .password("testPassword")
                    .nom("hadid")
                    .prenom("ouissal")
                    .email("hadid@example.com")
                    .role(USER) // Assuming Role is an enum in your application
                    .build();

            // Create an AuthenticationResponse object
            AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                    .token("generatedToken") // Assuming your authentication response includes a token
                    .build();

            // Mock the behavior of the authentication service to return the authenticationResponse when register is called
            when(authenticationService.register(registerRequest)).thenReturn(authenticationResponse);

            // Perform a POST request to the register endpoint using MockMvc
            mockMvc.perform(MockMvcRequestBuilders.post("/users/auth/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(registerRequest))) // Convert registerRequest to JSON
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    // Add more assertions based on the expected behavior of the endpoint
                    // For example, you can check the returned content, headers, etc.
                    // You can also verify other interactions or behaviors using Mockito
                    // For instance, verifying if the authenticationService.register method was called
                    .andReturn();
        }

        // Utility method to convert object to JSON string (You can use libraries like Jackson or Gson)
        private static String asJsonString(final Object obj) {
            try {
                final ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        @Test
        public void testLoginEndpoint() throws Exception {
            AuthenticationRequest authenticationRequest = new AuthenticationRequest(/* add necessary details */);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse(/* add necessary details */);

            when(authenticationService.authenticate(authenticationRequest)).thenReturn(authenticationResponse);
            // Create an instance of ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            String jsonRequest = objectMapper.writeValueAsString(registerRequest);

            mockMvc.perform(MockMvcRequestBuilders.post("/users/auth/login")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonRequest))
                    .andExpect(MockMvcResultMatchers.status().isOk());
            // Add more assertions based on the expected behavior of the endpoint
        }

        @Test
        public void testGetAllUsersEndpoint() throws Exception {
            when(utilisateurService.FindAll()).thenReturn(Collections.emptyList());

            mockMvc.perform(MockMvcRequestBuilders.get("/users/auth")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());
            // Add more assertions based on the expected behavior of the endpoint
        }

        @Test
        public void testGetUserByIdEndpoint() throws Exception {
            Long userId = 1L; // Replace with an existing user ID

            when(utilisateurService.FindById(userId)).thenReturn(new Utilisateur(1L,"hind1","p@$$word" ,"ouchfi","hind","hind.ouchfi@gmail.com" ,USER));

            mockMvc.perform(MockMvcRequestBuilders.get("/users/auth/" + userId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());

        }

        // Add more tests for other endpoints as needed
    }
