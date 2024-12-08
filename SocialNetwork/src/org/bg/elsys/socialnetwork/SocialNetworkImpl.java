package org.bg.elsys.socialnetwork;

import org.bg.elsys.socialnetwork.UserRegistrationException;
import org.bg.elsys.socialnetwork.Post;
import org.bg.elsys.socialnetwork.UserProfile;

import java.util.*;

public class SocialNetworkImpl implements SocialNetwork {
    private final Set<UserProfile> users;
    private final Collection<Post> posts;

    public SocialNetworkImpl() {
        this.users = new HashSet<>();
        this.posts = new ArrayList<>();
    }

    @Override
    public void registerUser(UserProfile userProfile) throws UserRegistrationException {
        if (userProfile == null) {
            throw new IllegalArgumentException("User profile cannot be null");
        }
        if (!users.add(userProfile)) {
            throw new UserRegistrationException("User profile is already registered");
        }
    }

    @Override
    public Set<UserProfile> getAllUsers() {
        return Collections.unmodifiableSet(users);
    }

    @Override
    public Post post(UserProfile userProfile, String content) throws UserRegistrationException {
        if (userProfile == null) {
            throw new IllegalArgumentException("User profile cannot be null");
        }
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        if (!users.contains(userProfile)) {
            throw new UserRegistrationException("User profile is not registered");
        }
        Post newPost = new SocialFeedPost(userProfile, content);
        posts.add(newPost);
        return newPost;
    }

    @Override
    public Collection<Post> getPosts() {
        return Collections.unmodifiableCollection(posts);
    }

    @Override
    public Set<UserProfile> getReachedUsers(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Post cannot be null");
        }
        Set<UserProfile> reachedUsers = new HashSet<>();
        UserProfile author = post.getAuthor();
        for (UserProfile user : users) {
            if (user.getInterests().stream().anyMatch(author.getInterests()::contains) && user.isFriend(author)) {
                reachedUsers.add(user);
            }
        }
        return reachedUsers;
    }

    @Override
    public Set<UserProfile> getMutualFriends(UserProfile userProfile1, UserProfile userProfile2) throws UserRegistrationException {
        if (userProfile1 == null || userProfile2 == null) {
            throw new IllegalArgumentException("User profiles cannot be null");
        }
        if (!users.contains(userProfile1) || !users.contains(userProfile2)) {
            throw new UserRegistrationException("One or both user profiles are not registered");
        }
        Set<UserProfile> mutualFriends = new HashSet<>(userProfile1.getFriends());
        mutualFriends.retainAll(userProfile2.getFriends());
        return mutualFriends;
    }

    @Override
    public SortedSet<UserProfile> getAllProfilesSortedByFriendsCount() {
        SortedSet<UserProfile> sortedProfiles = new TreeSet<>(Comparator.comparingInt((UserProfile u) -> u.getFriends().size()).reversed());
        sortedProfiles.addAll(users);
        return sortedProfiles;
    }
}