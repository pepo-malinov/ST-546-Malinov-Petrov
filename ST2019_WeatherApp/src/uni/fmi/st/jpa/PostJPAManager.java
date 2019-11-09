package uni.fmi.st.jpa;

import uni.fmi.st.models.Post;

public class PostJPAManager extends JPAManager<Post> {

	public PostJPAManager() {
		super(Post.class);
	}

}
