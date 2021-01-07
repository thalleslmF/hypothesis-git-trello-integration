package com.example.infrastructure.client.github;

public class CreateBranchRequest {
    private String sha;
    private String ref;

    public CreateBranchRequest(String sha1, String ref) {
        this.sha = sha1;
        this.ref = "refs/heads/" +ref;
    }

    public String getSha() {
        return sha;
    }

    public void setSha1(String sha1) {
        this.sha = sha1;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
