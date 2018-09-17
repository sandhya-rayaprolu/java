import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.ArrayList;

/*
from http://alexcode.tumblr.com/question_9
Given a text file and a word, find the positions that the word occurs in the file.
We’ll be asked to find the positions of many words in the same file.
*/

class Trie{
    
    
     TrieNode root = new TrieNode();

     boolean contains(String word){
         TrieNode current = root;
         char[] word_ = word.toCharArray();
         for(Character c:word_){
             TrieNode next = current.children.get(c);
             if(next==null) return false;
             else current=next;
         }
         return current.isTerminal;
     }
    

     List<Integer> getItem(String word){
         TrieNode current = root;
         char[] word_ = word.toCharArray();
         for(Character c:word_){
              TrieNode next = current.children.get(c);
              if(next==null) {next = new TrieNode(c); current.children.put(c,next); }
              current=next;
         }
         current.isTerminal=true;
         return current.positions;
     }
     
     void print(){
         List<TrieNode> l = new ArrayList<>();
         l.add(root);
         output(l,"");
     }
     
     //Depth First Search
     void output(List<TrieNode> currentPath,String indent){
         TrieNode current = currentPath.get(currentPath.size()-1);
         if(current.isTerminal){
             String word="";
             for(TrieNode n:currentPath) word+=n.letter;
             System.out.println(indent+word+" "+current.positions);
             indent+="  ";
         }
         for(Entry<Character,TrieNode> e:current.children.entrySet()){
             TrieNode node = e.getValue();
             List<TrieNode> newlist = new ArrayList<>();
             newlist.addAll(currentPath);
             newlist.add(node);
             output(newlist,indent);
         }
     }

}

class TrieNode{
    char letter;
    boolean isTerminal=false;
    Map<Character,TrieNode> children=new TreeMap<>();
    List<Integer> positions = new ArrayList<>();
    public TrieNode(){}
    public TrieNode(char letter){
        this.letter=letter;
    }
}

public class TrieTest{
    
    public static void main(String[] args){
        
        String text = readFile("C:/Sandhya/TrieTest.txt");
        String[] words = getWords(text);
        Trie t = createIndex(words);
        t.print();
        
        printPositions(t,"and");
    }
    
    static void printPositions(Trie t,String s){
        if(t.contains(s)){
            System.out.println(s+": "+t.getItem(s));
        }
    }
    
    static Trie createIndex(String[] words){
        Trie t = new Trie();
        for(int i=0;i<words.length;i++){
            t.getItem(words[i]).add(i);
        }
        return t;
    }
    
    static String[] getWords(String text){
        return text.toLowerCase().split(" ");
    }
    
    static String readFile(String filename){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename), Charset.defaultCharset())){
            String line = null;
            while ( (line = reader.readLine()) != null ) {sb.append(line);}
        }catch(Exception e){e.printStackTrace();}
        return sb.toString();
    }
}