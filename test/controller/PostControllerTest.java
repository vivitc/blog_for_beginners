package controller;

import model.Post;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class PostControllerTest {
    @InjectMocks
    PostController postController;

    Map<String, Object> modelMap;
    @Mock
    Post mockPost;

    @Test
    public void can_render_to_the_post_view() {
        MockitoAnnotations.initMocks(this);
        modelMap = new HashMap<String, Object>();

        String viewName = postController.renderPost(modelMap);

        assertThat((Post)modelMap.get("myObjPost"),is(mockPost));
        assertThat(viewName, is("post"));
    }
    @Test
    public void gives_back_xml_response_for_a_given_post() {
        MockitoAnnotations.initMocks(this);
        when(mockPost.toString()).thenReturn("post");
        String expectedResponse = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<post><content>post</content></post>";
        String actualResponse = postController.xmlPost();
        assertThat(actualResponse, is(expectedResponse));
    }
}
