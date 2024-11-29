use std::collections::HashMap;

fn is_anagram(s: &str, t: &str) -> bool {
    if s.len() != t.len() {
        false
    } else {
        let mut s_word_count = HashMap::new();
        let mut t_word_count = HashMap::new();
        for (si, ti) in s.chars().zip(t.chars()) {
            *s_word_count.entry(si).or_insert(0) += 1;
            *t_word_count.entry(ti).or_insert(0) += 1;
        }
        s_word_count == t_word_count
    }
}

fn main() {
    let s = "racecar";
    let t = "carrace";
    println!("Is anagram: {}", is_anagram(s, t));
    
    let s = "jar";
    let t = "jam";
    println!("Is anagram: {}", is_anagram(s, t));
}
