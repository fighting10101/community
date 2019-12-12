package life.majiang.community;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.GithubUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Test
    public void test1() {

        String s =
                "{"
                        + "\"login\":\"fighting10101\"                                                             "
                        + ",\"id\":33449288                                                                        "
                        + ",\"node_id\":\"MDQ6VXNlcjMzNDQ5Mjg4\"                                                   "
                        + ",\"avatar_url\":\"https://avatars1.githubusercontent.com/u/33449288?v=4\"               "
                        + ",\"gravatar_id\":\"\"                                                                   "
                        + ",\"url\":\"https://api.github.com/users/fighting10101\"                                 "
                        + ",\"html_url\":\"https://github.com/fighting10101\"                                      "
                        + ",\"followers_url\":\"https://api.github.com/users/fighting10101/followers\"             "
                        + ",\"following_url\":\"https://api.github.com/users/fighting10101/following{/other_user}\""
                        + ",\"gists_url\":\"https://api.github.com/users/fighting10101/gists{/gist_id}\"           "
                        + ",\"starred_url\":\"https://api.github.com/users/fighting10101/starred{/owner}{/repo}\"  "
                        + ",\"subscriptions_url\":\"https://api.github.com/users/fighting10101/subscriptions\"     "
                        + ",\"organizations_url\":\"https://api.github.com/users/fighting10101/orgs\"              "
                        + ",\"repos_url\":\"https://api.github.com/users/fighting10101/repos\"                     "
                        + ",\"events_url\":\"https://api.github.com/users/fighting10101/events{/privacy}\"         "
                        + ",\"received_events_url\":\"https://api.github.com/users/fighting10101/received_events\" "
                        + ",\"type\":\"User\"                                                                      "
                        + ",\"site_admin\":false                                                                   "
                        + ",\"name\":null                                                                          "
                        + ",\"company\":null                                                                       "
                        + ",\"blog\":\"\"                                                                          "
                        + ",\"location\":null                                                                      "
                        + ",\"email\":null                                                                         "
                        + ",\"hireable\":null                                                                      "
                        + ",\"bio\":null                                                                           "
                        + ",\"public_repos\":2                                                                     "
                        + ",\"public_gists\":0                                                                     "
                        + ",\"followers\":0                                                                        "
                        + ",\"following\":0                                                                        "
                        + ",\"created_at\":\"2017-11-07T09:33:38Z\"                                                "
                        + ",\"updated_at\":\"2019-12-12T09:51:09Z\"                                                "
                        + ",\"private_gists\":0                                                                    "
                        + ",\"total_private_repos\":0                                                              "
                        + ",\"owned_private_repos\":0                                                              "
                        + ",\"disk_usage\":340                                                                     "
                        + ",\"collaborators\":0                                                                    "
                        + ",\"two_factor_authentication\":false                                                    "
                        + ",\"plan\":{                                                                             "
                        + ",\"name\":\"free\"                                                                      "
                        + ",\"space\":976562499                                                                    "
                        + ",\"collaborators\":0                                                                    "
                        + ",\"private_repos\":10000}                                                               ";

        System.out.println(s);
        GithubUser githubUser = JSON.parseObject(s, GithubUser.class);
        System.out.println(githubUser.toString());
    }

}
