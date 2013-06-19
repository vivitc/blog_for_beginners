package model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PostTest {
    @Test
    public void it_represent_itself_by_it_content() {
        Post post = new Post("myPost");
        assertThat(post.toString(),is("myPost"));
    }
}
