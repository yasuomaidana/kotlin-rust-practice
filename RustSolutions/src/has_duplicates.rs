use std::collections::HashSet;

fn has_duplicates(arr: &[i32]) -> bool {
    let mut repeated = HashSet::new();
    for i in arr {
        if !repeated.insert(i) {
            return true;
        }
    }
    false
}

fn main() {
    let arr = [1, 2, 3, 3];
    println!("Has duplicate: {}", has_duplicates(&arr));
    let arr = [1, 2, 3, 4];
    println!("Has duplicate: {}", has_duplicates(&arr));
}