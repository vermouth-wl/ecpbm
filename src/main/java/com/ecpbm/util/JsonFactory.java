package com.ecpbm.util;

import com.ecpbm.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: com.ecpbm.util
 * @CLASS_NAME: JsonFactory
 * @USER: kagura
 * @Description TODO 工具类
 * @Date 2021/3/10 10:13 下午
 * @MONTH_NAME_FULL: 三月
 * @DAY: 10
 * @DAY_NAME_FULL: 星期三
 * @PROJECT_NAME: ecpbm
 **/
public class JsonFactory {

    // 给列表nodes中的TreeNode元素中的children赋值，递归调用buildTree()方法
    public static List<TreeNode> buildTree(List<TreeNode> nodes, int id){
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (TreeNode treeNode : nodes) {
            TreeNode node = new TreeNode();
            node.setId(treeNode.getId());
            node.setText(treeNode.getText());
            if (id == treeNode.getFid()) {
                // 递归调用buildTree()方法给TreeNode中的children属性赋值
                node.setChildren(buildTree(nodes, node.getId()));
                treeNodes.add(node);
            }
        }
        return treeNodes;
    }
}
