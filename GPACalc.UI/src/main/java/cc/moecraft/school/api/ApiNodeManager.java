package cc.moecraft.school.api;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
@Getter @ToString
public class ApiNodeManager
{
    private final ArrayList<ApiNode> registeredNodes = new ArrayList<>();

    /**
     * Register some nodes.
     *
     * @param node Nodes.
     */
    public void register(ApiNode ... node)
    {
        registeredNodes.addAll(Arrays.asList(node));
    }

    /**
     * Get nodes by name
     *
     * @param nodeName Node name.
     * @return Registered nodes.
     */
    public ArrayList<ApiNode> getNodes(String nodeName)
    {
        nodeName = nodeName.toLowerCase();
        ArrayList<ApiNode> result = new ArrayList<>();

        for (ApiNode node : registeredNodes)
            if (node.nodeName().equals(nodeName)) result.add(node);

        return result;
    }
}
