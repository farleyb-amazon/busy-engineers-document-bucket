// Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package sfw.example.esdkworkshop.datamodel;

import java.util.UUID;

/** Models the unique key for identifying pointer items in S3 and DynamoDB. */
public class UuidKey {
  private final UUID key;

  protected UuidKey() {
    key = UUID.randomUUID();
  }

  protected UuidKey(String uuid) {
    key = UUID.fromString(uuid);
  }

  @Override
  public String toString() {
    return key.toString();
  }
}
