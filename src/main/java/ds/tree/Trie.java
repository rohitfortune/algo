package ds.tree;

import java.util.HashMap;



public class Trie {
    class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean endOfString = false;
    }

    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            Character ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
           current = node;
        }
        current.endOfString = true;
        System.out.println(word+" successfully inserted");
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i=0; i<word.length(); i++){
            Character ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null){
                return false;
            }
            current = node;
        }
        return current.endOfString;
    }

    public boolean delete(String word){
        if (search(word)) {
            System.out.println(word + " successfully deleted");
            return delete(root, word, 0);
        }
        else
            return false;
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        Character ch = word.charAt(index);
        TrieNode curr = parentNode.children.get(ch);
        //boolean canThisBeDeleted = false;
        if (curr.children.size() > 1){
            delete(curr, word, index+1);
            return false;
        }
        if (index == word.length()-1){
            if (curr.children.size() >=1){
                curr.endOfString = false;
                return false;
            }
            else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        if (curr.endOfString){
            delete(curr, word, index+1);
            return false;
        }
        boolean canThisBeDeleted = delete(curr, word, index+1);
        if (canThisBeDeleted) {
            parentNode.children.remove(ch);
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("rohit");
        trie.insert("ritu");
        trie.delete("ritu");
        trie.insert("prasad");
    }

}
