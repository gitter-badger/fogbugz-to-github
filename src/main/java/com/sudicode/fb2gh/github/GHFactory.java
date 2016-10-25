package com.sudicode.fb2gh.github;

/**
 * Factory used to authenticate and interact with <a href="https://github.com">GitHub</a>.
 */
public final class GHFactory {

    /**
     * Construct a new {@link GitHub}, authenticating via OAuth.
     *
     * @param token The OAuth token.
     * @see <a href="https://developer.github.com/v3/oauth/">OAuth</a>
     */
    public static GitHub newGitHub(final String token) {
        return new GitHubImpl(token);
    }

    /**
     * Construct a new {@link GitHub}, authenticating via username and password.
     *
     * @param username GitHub username
     * @param password GitHub password
     */
    public static GitHub newGitHub(final String username, final String password) {
        return new GitHubImpl(username, password);
    }

}