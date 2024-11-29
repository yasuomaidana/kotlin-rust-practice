fn anagram_groups(words: Vec<String>) -> Vec<Vec<String>> {
    use std::collections::HashMap;
    let mut anagrams = HashMap::new();
    for word in words {
        let mut word_count: Vec<i128> = vec![0; 26];
        for c in word.chars() {
            *word_count.get_mut((c as u8 - b'a') as usize).unwrap() += 1;
        }
        anagrams.entry(word_count).or_insert(vec![]).push(word);
    }
    anagrams.into_iter().map(|(_, v)| v).collect()
}

fn main() {
    let words = vec![
        "eat".to_string(),
        "tea".to_string(),
        "tan".to_string(),
        "ate".to_string(),
        "nat".to_string(),
        "bat".to_string(),
    ];
    println!("{:?}", anagram_groups(words));
}
